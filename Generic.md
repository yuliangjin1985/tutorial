## generic

#### ? extends wildcard

When the extends wild card used to define a parameterized type, the type can not be used to add elements(The exception is null).
List<? extends Number> nums = ints; nums is defined to be a List that accepts subtypes of Number, but which subtype is not determined.

```
public static void main(String[] args) {
           List<Integer> ints = new ArrayList<Integer>();
           ints.add(1);
           ints.add(2);
           List<? extends Number> nums = ints;

           nums.add(3); //Compile error

           nums.add(4.5); //Compile error

           nums.add(null); //Only null could be added
   }
```

#### ? super wildcard
Elements can be gotten, but not typed.

```
public class SuperWildCard {

    public static void main(String[] args) {
        List<? super Integer> nums = new ArrayList<>();

        nums.add(5);

        System.out.println(nums.get(0));

        Integer integer = nums.get(0); //Compile error
        Object object = nums.get(0);

    }
}
```