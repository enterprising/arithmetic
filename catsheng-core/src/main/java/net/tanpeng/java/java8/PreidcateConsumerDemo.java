package net.tanpeng.java.java8;

import java.util.function.Consumer;
import java.util.function.Predicate;

// 说明：
/**
 * Predicate 即判断输入的对象是否符合某个条件。
 * Consumer 即接口表示一个接受单个输入参数并且没有返回值的操作。
 * 不像其他函数式接口，Consumer接口期望执行带有副作用的操作（译者注：Consumer的操作可能会更改输入参数的内部状态）。
 */

/**
 * Created by 官方demo on 18/1/30.
 * <p>
 * 使用Predicate接口实现类的test()方法 判断输入的Student对象是否拥有费用打折的资格，
 * 然后使用Consumer接口的实现类更新输入的Student对象的折扣
 */
public class PreidcateConsumerDemo {
    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {

        //Use the predicate to decide when to update the discount.

        if (predicate.test(student)) {

            //Use the consumer to update the discount value.

            consumer.accept(student);
        }

        return student;

    }

    public static void main(String[] args) {

        Student student1 = new Student("Ashok", "Kumar", 9.5);

        student1 = updateStudentFee(student1,
                //Lambda expression for Predicate interface
                student -> student.grade > 8.5,
                //Lambda expression for Consumer inerface
                student -> student.feeDiscount = 30.0);

        student1.printFee();

        Student student2 = new Student("Rajat", "Verma", 8.0);

        student2 = updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);

        student2.printFee();

    }

}
