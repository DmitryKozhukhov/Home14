public class Main {

    public static void main(String[] args) {

        int[] arr = {6, 2, 4, 5, 0, 1, 5, 1, 7};
        array(arr);
        System.out.println(checkArray(arr));
    }


    public static int[] array(int[] arr) {

        int [] result = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                result = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, result, 0, arr.length - i - 1);
            }
        }

        try {
            for (int j : result) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }catch (NullPointerException e){
            throw new RuntimeException("Нет 4ок в массиве", e);
        }
        return result;
    }

    public static boolean checkArray(int[] arr){

        boolean a = false;
        boolean b = false;

        for (int x : arr) {
            if (x == 1) {
                a = true;
                break;
            }
        }
        for (int x : arr) {
            if (x == 4) {
                b = true;
                break;
            }
        }
        return a && b;
    }
}