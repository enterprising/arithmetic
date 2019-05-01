package net.tanpeng.arithmetic.ememiddle;

/**
 * 6. 给4个数字，判断能不能用加减乘除算出24点。比如 5，5，5，1。可以算出24点，返回true。 (5-1/5)*5 = 24;
 * 点评：部分有竞赛背景的同学不妨拿这道题目难为一下，只用返回true or false就可以，不需要给出具体表达式。
 * 对于有ACM背景的同学来说30分钟应该是可以写出来的，其他正常人类就不要用这道题目为难人家了。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T6 {
    public static void main(String[] args) {
        System.out.println(normal6(new int[]{5, 5, 5, 1}));
    }

    public static boolean normal6(int[] array) {
        if (array == null || array.length != 4) {
            return false;
        }
        float[] newArray = new float[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return helper(newArray);
    }

    private static boolean helper(float[] array) {
        if (array.length == 2) {
            if (array[0] + array[1] == 24) {
                return true;
            } else if (Math.abs(array[0] - array[1]) == 24) {
                return true;
            } else if (array[0] * array[1] == 24) {
                return true;
            } else {
                if (array[0] != 0) {
                    if (array[1] / array[0] == 24) {
                        return true;
                    }
                }
                if (array[1] != 0) {
                    if (array[0] / array[1] == 24) {
                        return true;
                    }
                }
            }
            return false;
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                float[] newArray = generateNewArray(array, i, j);
                newArray[newArray.length - 1] = array[i] + array[j];
                if (helper(newArray)) {
                    return true;
                }
                newArray[newArray.length - 1] = Math.abs(array[i] - array[j]);
                if (helper(newArray)) {
                    return true;
                }
                newArray[newArray.length - 1] = array[i] * array[j];
                if (helper(newArray)) {
                    return true;
                }

                if (array[i] != 0) {
                    newArray[newArray.length - 1] = array[j] / array[i];
                    if (helper(newArray)) {
                        return true;
                    }
                }

                if (array[j] != 0) {
                    newArray[newArray.length - 1] = array[i] / array[j];
                    if (helper(newArray)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static float[] generateNewArray(float[] array, int i, int j) {
        float[] res = new float[array.length - 1];
        for (int k = 0, m = 0; k < array.length; k++) {
            if (k != i && k != j) {
                res[m++] = array[k];
            }
        }
        return res;
    }
}
