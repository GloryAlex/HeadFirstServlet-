package Chapter6;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 一个测试用的bean类
 */
public class Dog implements HttpSessionBindingListener, HttpSessionActivationListener {
    private final String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        //我知道我被绑定到一个会话时要运行的代码
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        //我知道我被从一个会话中解绑时要运行的代码
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        //将非Serializable字段置为某种状态以迁移至其他VM
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        //用于恢复字段
        //回滚在sessionWillPassivate所作的操作
    }
}
