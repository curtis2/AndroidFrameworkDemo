# AndroidFrameworkDemo
- **mvc模式：**
 MVC 架构模式中，activity或者fragment充当了control的角色,xml作为view, 其他的网络处理或者数据方法作为modul层
 但是因为xml的能力有限，所以在activity会进行view的操作。
 这样导致两个缺点：
  1.activity过重，并且和view耦合
  2.view和model耦合


- **mvp模式:**
  通过presenter将module和view层隔离开，activity和xml一起充当view层。
  mvp模式也有一些问题：
  1.presenter过于厚，而且当页面过于负逻辑很多的时候，接口太多不好维护
  2.presenter会持有activity的引用导致内存泄漏
  **优化：**
  1.可以通过弱引用来避免内存泄漏
  2.通过设计一些公共的接口来避免接口过多
  参考：https://github.com/sockeqwe/mosby

- **mvvm模式:**
  暂时没看出他的优势在哪里
 缺点： 目前的databing能做的有限，所以会导致activity处理很多逻辑和view操作，所以activity会变的很厚
 
- **mvp+databing实践**
最佳实践：通过databing+mvp模式，通过databing简化activity中的view操作，通过presenter分担原来activity的逻辑处理

参考：
认清Android框架 MVC，MVP和MVVM：
http://blog.csdn.net/jdsjlzx/article/details/51174396#comments

MVC，MVP 和 MVVM 的图示：
http://www.ruanyifeng.com/blog/2015/02/mvcmvp_mvvm.html
