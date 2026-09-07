XML Based Configuration in Spring

My Spring Core Learning Notes --- Hinglish

Is project me maine Spring ke XML Based Configuration ko practically
learn kiya hai.
Ye README meri revision aur interview preparation ke liye hai.

📚 What I Learned

Why XML configuration exists in Spring

What configuration metadata means

How Spring converts XML into BeanDefinition objects

How to create your first bean using <bean>

How to load XML using ClassPathXmlApplicationContext

How to get beans by name and type

Difference between id, name, and aliases

Constructor injection in XML

Setter injection in XML

Difference between value and ref

How to handle duplicate beans

XML autowiring using byName, byType, and constructor

Singleton and prototype scope in XML

Bean lifecycle using init-method and destroy-method

Collection injection using List and Map

Splitting XML files using <import>

Can XML and annotations work together?

🔥 XML Configuration Working --- Step by Step

Spring XML configuration ko samajhne ke liye complete flow ko is tarah
samjho:

beans.xml
   ↓
Spring XML Parser
   ↓
Bean Definitions
   ↓
BeanDefinition Objects
   ↓
IoC Container / BeanFactory
   ↓
Bean Creation
   ↓
Dependency Injection
   ↓
Bean Ready to Use

Step 1: XML Configuration File

Sabse pehle hum src/main/resources ke andar ek XML file banate hain:

src/main/resources/beans.xml

Example:

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="orderService"
          class="in.saurabh.OrderService"/>

</beans>

Yahan:

bean → Spring ko batata hai ki ek bean define karni hai.

id → bean ka unique name.

class → kis Java class ka object Spring create karega.

Step 2: Spring XML ko Read karta hai

Jab hum XML ko Spring ke context me load karte hain:

ApplicationContext context =
        new ClassPathXmlApplicationContext("beans.xml");

ClassPathXmlApplicationContext classpath se beans.xml ko load karti
hai.

Spring XML ko parse karta hai aur usme diye gaye bean configuration ko
samajhta hai.

Step 3: XML se BeanDefinition banti hai

Spring directly XML ko object nahi banata.

Pehle XML me likhi information ko internally BeanDefinition ke form
me represent karta hai.

Example:

<bean id="orderService"
      class="in.saurabh.OrderService"/>

Spring internally roughly ye information remember karta hai:

Bean Name  → orderService
Class      → in.saurabh.OrderService
Scope      → singleton (default)

Ye metadata Spring ke liye bean create aur manage karne ka blueprint
hota hai.

Step 4: BeanDefinition IoC Container me Register hoti hai

Spring BeanDefinition ko container ke andar register karta hai.

Conceptually:

XML
 ↓
BeanDefinition
 ↓
BeanFactory / ApplicationContext

Ab Spring ko pata hai:

"Mujhe orderService naam ki bean manage karni hai aur iska class
OrderService hai."

Step 5: Spring Bean Create karta hai

Default singleton scope me Spring bean ka object create karta hai.

Conceptually:

OrderService orderService = new OrderService();

Lekin important point:

Ye object creation Spring container manage karta hai, hum manually
nahi karte.

Step 6: Dependencies Inject hoti hain

Agar OrderService ko kisi aur object ki dependency hai, to XML
configuration ke according Spring dependency inject kar sakta hai.

Example:

<bean id="paymentService"
      class="in.saurabh.PaymentService"/>

<bean id="orderService"
      class="in.saurabh.OrderService">
    <property name="paymentService"
              ref="paymentService"/>
</bean>

Yahan ref ka matlab hai:

Kisi existing Spring bean ka reference dena.

Step 7: Bean Ready

Bean create hone aur required dependencies inject hone ke baad bean
application me use ki ja sakti hai.

OrderService orderService =
        context.getBean("orderService", OrderService.class);

Then:

orderService.placeOrder();

🧠 Simple Real-Life Analogy

Socho beans.xml ek instruction sheet hai.

XML
 ↓
"OrderService naam ka object chahiye"
 ↓
Spring instruction read karta hai
 ↓
BeanDefinition banata hai
 ↓
Container bean ko manage karta hai
 ↓
Object create hota hai
 ↓
Dependencies inject hoti hain
 ↓
Object ready

Isliye Spring me XML ko configuration metadata kaha jata hai.

1. Why XML Configuration Exists in Spring?

Spring ke early versions me annotations itne commonly available/use nahi
hote the.

Isliye configuration ko external XML file me define karna common
approach tha.

Benefits:

Configuration Java code se separate rehti thi.

Bean configuration ko XML se control kar sakte the.

Dependencies ko external configuration ke through define kar sakte
the.

Aaj ke Spring Boot applications me annotations aur Java configuration
zyada common hain, lekin XML samajhna Spring Core concepts ko deeply
samajhne me useful hai.

2. Configuration Metadata Kya Hai?

Configuration metadata ka simple meaning hai:

Spring ko information dena ki application ke objects/beans ko kaise
create aur manage karna hai.

Example:

<bean id="orderService"
      class="in.saurabh.OrderService"/>

Ye Spring ko metadata provide karta hai:

Bean Name = orderService
Bean Class = OrderService

3. First Bean Using <bean>

Basic syntax:

<bean id="orderService"
      class="in.saurabh.OrderService"/>

Java:

ApplicationContext context =
        new ClassPathXmlApplicationContext("beans.xml");

OrderService service =
        context.getBean("orderService", OrderService.class);

4. ClassPathXmlApplicationContext

XML file load karne ke liye:

ApplicationContext context =
        new ClassPathXmlApplicationContext("beans.xml");

Agar file src/main/resources ke andar hai, to:

new ClassPathXmlApplicationContext("beans.xml");

use kar sakte hain.

5. Bean Ko Name Aur Type Se Get Karna

By name

OrderService service =
        context.getBean("orderService", OrderService.class);

By type

OrderService service =
        context.getBean(OrderService.class);

By type use karte waqt agar same type ki multiple beans available hain,
to ambiguity ho sakti hai.

6. id, name aur Alias

id

<bean id="orderService"
      class="in.saurabh.OrderService"/>

id bean ka primary identifier hai.

name

<bean name="orderService"
      class="in.saurabh.OrderService"/>

name alternate names/aliases provide karne ke liye useful hai.

Example:

<bean id="orderService"
      name="order, myOrder"
      class="in.saurabh.OrderService"/>

Isse same bean ko multiple names se refer kiya ja sakta hai.

7. Constructor Injection

Agar dependency constructor ke through deni hai:

<bean id="paymentService"
      class="in.saurabh.PaymentService"/>

<bean id="orderService"
      class="in.saurabh.OrderService">
    <constructor-arg ref="paymentService"/>
</bean>

Java class:

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}

Flow:

Spring
 ↓
PaymentService bean
 ↓
OrderService constructor
 ↓
PaymentService injected

8. Setter Injection

Setter method ke through dependency inject karna:

<bean id="paymentService"
      class="in.saurabh.PaymentService"/>

<bean id="orderService"
      class="in.saurabh.OrderService">

    <property name="paymentService"
              ref="paymentService"/>

</bean>

Java:

public class OrderService {

    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}

9. value vs ref

value

Simple value dene ke liye:

<property name="name" value="Saurabh"/>

Yahan "Saurabh" ek simple value hai.

ref

Kisi existing Spring bean ka reference dene ke liye:

<property name="paymentService"
          ref="paymentService"/>

Yaad rakhne ka simple rule

value → actual/simple value
ref   → another Spring bean ka reference

10. Duplicate Beans

Agar same bean type ki multiple beans hain:

<bean id="upiPayment"
      class="in.saurabh.UPIPaymentMode"/>

<bean id="cardPayment"
      class="in.saurabh.CardPaymentMode"/>

Aur tum:

context.getBean(PaymentMode.class);

karoge, to Spring confuse ho sakta hai because multiple candidates hain.

Aise cases me correct bean name/reference specify karna important hai.

11. XML Autowiring

Spring XML me autowiring ke different modes milte hain.

byName

<bean id="paymentService"
      class="in.saurabh.PaymentService"
      autowire="byName"/>

Spring matching property/bean name ke basis par dependency find karta
hai.

byType

<bean id="orderService"
      class="in.saurabh.OrderService"
      autowire="byType"/>

Spring matching type ke basis par dependency find karta hai.

Agar same type ki multiple beans hain, ambiguity aa sakti hai.

constructor

Spring constructor ke parameter type ke basis par dependency resolve
karta hai.

12. Singleton and Prototype Scope

Singleton

Default scope:

<bean id="orderService"
      class="in.saurabh.OrderService"
      scope="singleton"/>

Ek Spring container ke andar normally same bean ka same instance return
hota hai.

getBean()
   ↓
Same Object

Prototype

<bean id="orderService"
      class="in.saurabh.OrderService"
      scope="prototype"/>

Har getBean() call par new instance milta hai.

getBean() → Object 1
getBean() → Object 2
getBean() → Object 3

13. Bean Lifecycle

Spring bean lifecycle me broadly:

Bean Definition
      ↓
Bean Instantiation
      ↓
Dependency Injection
      ↓
Initialization
      ↓
Bean Ready
      ↓
Container Shutdown
      ↓
Destroy

XML me custom initialization aur destruction methods specify kar sakte
hain:

<bean id="orderService"
      class="in.saurabh.OrderService"
      init-method="init"
      destroy-method="destroy"/>

Java:

public void init() {
    System.out.println("Bean initialized");
}

public void destroy() {
    System.out.println("Bean destroyed");
}

14. Collection Injection --- List

Example:

<property name="items">
    <list>
        <value>Java</value>
        <value>Spring</value>
        <value>SQL</value>
    </list>
</property>

Spring list ko property me inject karega.

15. Collection Injection --- Map

Example:

<property name="skills">
    <map>
        <entry key="language" value="Java"/>
        <entry key="framework" value="Spring"/>
    </map>
</property>

Yahan key-value pair inject kiye ja rahe hain.

16. XML Files Ko Split Karna Using <import>

Large application me ek hi XML file bahut badi ho sakti hai.

Isliye configuration ko multiple XML files me split kar sakte hain.

Example:

beans.xml
payment.xml
user.xml
order.xml

Main XML me:

<import resource="payment.xml"/>
<import resource="user.xml"/>
<import resource="order.xml"/>

Isse configuration organized aur manageable rehti hai.

17. Can XML and Annotations Work Together?

Yes. XML aur annotations ek hi Spring application me use kiye ja
sakte hain.

Example XML:

<context:component-scan
    base-package="in.saurabh"/>

Aur Java class:

@Component
public class OrderService {
}

Is approach me XML aur annotation based configuration together kaam kar
sakte hain.

📝 Quick Revision

XML Configuration
        ↓
beans.xml
        ↓
XML Parser
        ↓
BeanDefinition
        ↓
IoC Container
        ↓
Bean Creation
        ↓
Dependency Injection
        ↓
Initialization
        ↓
Bean Ready

Important Classes

ApplicationContext
        ↓
ClassPathXmlApplicationContext

Important XML Tags

<bean>
<property>
<constructor-arg>
<list>
<map>
<import>

Important Attributes

id
name
class
scope
ref
value
autowire
init-method
destroy-method

🎯 Interview Questions I Should Be Able To Answer

What is XML based configuration in Spring?

Why was XML configuration used in Spring?

What is configuration metadata?

What is a BeanDefinition?

How does Spring create a bean from XML?

What is ClassPathXmlApplicationContext?

Difference between id and name?

What is an alias in Spring?

What is constructor injection?

What is setter injection?

Difference between value and ref?

What happens when multiple beans of the same type exist?

What is XML autowiring?

Difference between byName and byType?

What is singleton scope?

What is prototype scope?

What is bean lifecycle?

What are init-method and destroy-method?

How do you inject List and Map in XML?

Why do we use <import>?

Can XML configuration and annotations work together?

💡 My Understanding

Spring XML configuration ka main idea ye hai ki hum Spring ko XML file
ke through batate hain ki kaunse objects/beans create aur manage karne
hain aur unki dependencies kya hain.

Spring XML ko read karta hai → configuration ko BeanDefinition ke form
me represent karta hai → IoC Container me register karta hai → required
beans create karta hai → dependencies inject karta hai → bean ko manage
karta hai.

This helps me understand the internal working of Spring IoC and
Dependency Injection.
