package com.simon.mvp.base;

import java.lang.ref.WeakReference;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 * 通过设置弱引用，避免Presenter一直持有activity对象，导致内存泄漏
 * 参考：https://github.com/sockeqwe/mosby
 *
 */
public class MvpBasePresenter<V extends MvpView> {

    //为view添加弱引用
    private WeakReference<V> viewRef;

    protected  void attachView(V view){
        this.viewRef=new WeakReference<>(view);
    }

    public V getView() {
        return viewRef==null? null : viewRef.get();
    }

    /**
     * 调用presenter持有的activity的对象之前，先判断该activity的实例是否存在，如果不存在表示已经被回收了。
     * @return
     */
    public boolean isViewAttached(){
        return viewRef!=null&&viewRef.get()!=null;
    }

    /**
     * 销毁activity的时候，情况引用
     */
    protected  void detachView(){
      if(viewRef!=null){
          viewRef.clear();
          viewRef=null;
      }
    }
}
