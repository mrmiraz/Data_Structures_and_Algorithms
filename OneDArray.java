
package learning;

public class OneDArray {
   int[] array;

    public OneDArray() {
        int result[] ={};
       array = result;
    }
    
    public void addElement(int element){
        int[] result = new int[array.length+1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[result.length - 1] = element;
        array = result;
    }
    public void addElement(int index, int element){
        int[] result = new int[array.length+1];
        int i;
        for(i = 0; i < result.length; i++){
            if(i < index)result[i] = array[i];
            else if(i == index){
                result[index] = element;
            }
            else {
                result[i] = array[i - 1];
            }
        }
        array = result;
    }
    
    public int search(int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return i;
               
            }
        }
        return -1;
    }
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
//        ArrayList<Integer> array = new ArrayList<>();
        
        OneDArray array1  = new OneDArray();
        
        array1.addElement(1);
        array1.addElement(3);
        array1.addElement(4);
        array1.addElement(1, 2);
        System.out.println(array1.search(4));
        
//        array1.print();

    }
}
