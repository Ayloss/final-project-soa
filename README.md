# SOA Final Project
使用Spring Cloud模拟分布式的支付交易。  
不过由于时间紧迫没有仔细思考业务逻辑就做了，只是非常简单的一个demo。
## 启动
 - 将工程导入idea
 - 添加8个maven模块到maven。
 - 执行init.sql 建表以及插入数据
 - 启动8个server
 - 访问
    - localhost:8100/reg.html 注册页面
    - localhost:8100/login.html 登录页面
    - localhost:8100/pay.html 支付页面
    - localhost:8100/payment-done.html 支付结束页面
    - localhost:8000 eureka服务注册中心页面
 - 建议先访问注册页面，然后登陆，再执行支付

## 模块
总共有8个模块(服务)

服务 | 使用技术 | 端口
---|---|---
服务注册中心(service-center) | eureka,spring mvc | 8000
支付客户端(pay-client) | eureka,feign,angularjs,spring mvc | 8100
支付权限提供者(pay-authority-provider) | eureka,spring data jpa,feign,spring mvc | 8200
 银行转账服务提供者(bank-transfer-provider)| eureka,spring data jpa,spring mvc| 8300
支付服务提供者(pay-provider)| eureka,spring data jpa,feign,spring mvc| 8400
银行转账服务消费者(bank-transfer-consumer) | eureka,feign,spring mvc| 8500
支付权限服务消费者(pay-authority-consumer)| eureka,feign,spring mvc| 8600
支付服务消费者(pay-authority) |eureka,feign,spring mvc | 8700


## 角色
以上8个模块共有4种角色
 - 服务注册中心：用于注册所有的服务，使得服务之间可以被互相发现
 - 服务提供者：提供服务给消费者调用，可以集群。
 - 服务消费者：调用服务提供者的服务，同时作为使用服务的入口，提供负载均衡。
 - 客户端：调用各类服务组成业务逻辑。

服务之间的调用呈现以下结构：
![image](https://github.com/StatusCode200/final-project-soa/blob/master/img/network.png)

## 数据表
数据库一共三张表
### User
用户信息表
字段 | 描述
---|---
 id| 用户唯一标识 
 telephone| 手机号
 paypwd| 支付密码
 bankcard|用户绑定的银行卡号
 password|用户登录密码
 
### exchange_order
订单表
字段 | 描述
---|---
id | 订单唯一标识
payer_id| 支付方id
target_id| 收款方id
type | 交易类型
payment_key | 支付秘钥,由jwt加密
begin_time | 支付开始时间
end_time | 支付结束时间
status | 订单状态,0表示未支付,1表示已支付
### bankcard
银行卡表,该表在界面上没有任何输入，需要自己导入
字段 | 描述
---|---
id | 银行卡唯一标识
card_id |银行卡id
name | 客户名称
id_numer|身份证号

## 支付客户端
客户端共有5个业务逻辑。其中，自己本身并不实现任何服务，所有服务都通过调用其他服务提供者。
 - 注册
 - 登录
 - 创建订单
 - 验证支付密码
 - 执行支付

下面说明每个业务逻辑的执行步骤
### 注册
1. 调用pay-authority的服务验证手机号是否已经被注册
2. 调用bank-transfer的服务验证银行卡号是否存在
3. 调用pay-authority的服务执行注册操作

### 登录
1. 调用pay-autority的服务验证用户名密码，获得用户实体。
2. 将用户信息放入session。(因为还要配置安全模块比较麻烦，因此直接将用户信息放入session中)

### 创建订单
1. 从session中获得用户id
2. 调用pay服务创建订单

### 验证支付密码
1. 从session中获得用户id
2. 调用pay-authority的服务验证支付密码

### 执行支付
1. 调用pay的服务执行支付


## 支付权限服务提供者
该服务提供者包含了以下服务，由于每个服务都是简单地查询数据库，因此不进行详细说明

服务url | 描述
---|---
GET /auth/telephone | 验证电话是否已经被注册
POST /auth/login | 验证登录
POST /auth/login | 验证支付密码
GET /user | 获取用户信息
POST /user | 创建用户

## 银行转账服务提供者
服务url | 描述
---|---
GET /auth/bankcard| 验证银行卡是否存在
POST /do-transfer | 执行转账

## 支付服务提供者
服务url | 描述
---|---
POST /order | 创建订单。
POST /do-pay | 执行支付。

### 创建订单
1.根据订单的类型，支付方id，收款方id创建订单
2.对每个订单根据以上三个属性生成paymentKey

### 执行支付
1. 调用bank-transfer服务执行转账
2. 修改订单状态
