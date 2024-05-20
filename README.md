# 学习多线程知识
> 想深入学习一下并发编程技术，许多开源框架的原理都使用到了并发编程技术，这似乎是进阶技术的必经之路
> 此仓库是我学习并发技术的笔记和代码


## 线程的状态
1. new 创建线程 没有调用start方法
2. runnable 调用start方法 ， 只能变成running或者意外终止
线程的运行与否，得听cpu调度
总结： 线程调用start方法，状态编程runnable,听cpu调度
3. running: cpu通过轮询从任务得可执行队列中选中线程，那么它才能真正得执行自己得代码逻辑
可以变化的状态
terminated: 调用stop
blocked: sleep, wait, 网络io， 获取锁，yield
4. blocked
可以变化的状态
terminated: 调用stop
runnable: 阻塞结束，sleep结束， notify/notifyAll,获取到锁资源，阻塞过程中被打断
5. terminated
整个生命周期结束

## 写时复制
1. cow 写时复制，就是在写的时候，先复制一下原来的数据，然后改复制的数据，不改变原数据，直接替换原数据
2. 为啥这样干？
- 主要目的是在读多写少的场景下，让大量的读请求在无需加锁的情况下保证多线程并发读写线程安全
- 但是并不能做到强一致性
- CopyOnWriteArrayList 就是用的这个机制


