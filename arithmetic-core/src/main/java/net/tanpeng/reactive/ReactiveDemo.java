package net.tanpeng.reactive;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by peng.tan on 2019/11/22.
 */
public class ReactiveDemo {
    public static void main(String[] args) {
        // 被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            // 创建 ObservableOnSubscribe 并重写其 subscribe 方法，
            // 就可以通过 ObservableEmitter 发射器向观察者发送事件。
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                System.out.println("=========================currentThread name: " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        // 观察者
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("======================onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("======================onNext  " + o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("======================onError");
            }

            @Override
            public void onComplete() {
                System.out.println("======================onComplete");
            }
        };

        // 观察者订阅被观察者
        observable.subscribe(observer);
    }

}

