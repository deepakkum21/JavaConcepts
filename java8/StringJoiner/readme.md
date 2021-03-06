# Java StringJoiner
- Java added a new final class StringJoiner in java.util package. 
- It is used to **construct a sequence of characters separated by a delimiter**. 
- User **can create string by passing delimiters like comma(,), hyphen(-)** etc. 
- User **can also pass prefix and suffix to the char sequence**

## StringJoiner Constructors

| **Constructor** |	**Description** |
| --------------- | --------------- |                   
| Public StringJoiner(CharSequence delimiter) |	It constructs a StringJoiner with no characters in it, with no prefix or suffix, and a copy of the supplied delimiter. It throws NullPointerException if delimiter is null.
| Public StringJoiner(CharSequence delimiter,CharSequence prefix,CharSequence suffix) |	It constructs a StringJoiner with no characters in it using copies of the supplied prefix, delimiter and suffix. It throws NullPointerException if prefix, delimiter, or suffix is null. |

## StringJoiner Methods

| **Method** |	**Description** |
| ---------- | ---------------- |                   
| Public StringJoiner add(CharSequence newElement) |	It adds a copy of the given CharSequence value as the next element of the StringJoiner value. If newElement is null,"null" is added.
| Public StringJoiner merge(StringJoiner other) |	It adds the contents of the given StringJoiner without prefix and suffix as the next element if it is non-empty. If the given StringJoiner is empty, the call has no effect.
| Public int length() |	It returns the length of the String representation of this StringJoiner.
| Public StringJoiner setEmptyValue(CharSequence emptyValue) |	It sets the sequence of characters to be used when determining the string representation of this StringJoiner and no elements have been added yet, that is, when it is empty.

## Example

            // importing StringJoiner class  
            import java.util.StringJoiner;  

            public class StringJoinerExample {  
                public static void main(String[] args) {  
                    StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter   
                    
                    // Adding values to StringJoiner  
                    joinNames.add("Rahul");  
                    joinNames.add("Raju");  
                    joinNames.add("Peter");  
                    joinNames.add("Raheem");  
                            
                    System.out.println(joinNames);  
                }  
            }  

## adding prefix and suffix

            // importing StringJoiner class  
            import java.util.StringJoiner;
            
            public class StringJoinerExample {  
                public static void main(String[] args) {  
                    StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   
                    
                    // Adding values to StringJoiner  
                    joinNames.add("Rahul");  
                    joinNames.add("Raju");  
                    joinNames.add("Peter");  
                    joinNames.add("Raheem");  
                            
                    System.out.println(joinNames);  
                }  
            }  

## Merge Two StringJoiner

            // importing StringJoiner class  
            import java.util.StringJoiner;  
            public class StringJoinerExample {  
                public static void main(String[] args) {  
            
                    StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   
                    
                    // Adding values to StringJoiner  
                    joinNames.add("Rahul");  
                    joinNames.add("Raju");  
            
                    // Creating StringJoiner with :(colon) delimiter  
                    StringJoiner joinNames2 = new StringJoiner(":", "[", "]");  // passing colon(:) and square-brackets as delimiter   
                    
                    // Adding values to StringJoiner  
                    joinNames2.add("Peter");  
                    joinNames2.add("Raheem");  
            
                    // Merging two StringJoiner  
                    StringJoiner merge = joinNames.merge(joinNames2);   
                    System.out.println(merge);  
                }  
            }


## StringJoiner Methods

            // importing StringJoiner class  
            import java.util.StringJoiner; 
            
            public class StringJoinerExample {  
                public static void main(String[] args) {  
                    StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter   
                    
                    // Prints nothing because it is empty  
                    System.out.println(joinNames);  
                    
                    // We can set default empty value.  
                    joinNames.setEmptyValue("It is empty");  
                    System.out.println(joinNames);  
                    
                    
                    // Adding values to StringJoiner  
                    joinNames.add("Rahul");  
                    joinNames.add("Raju");  
                    System.out.println(joinNames);  
                    
                    // Returns length of StringJoiner  
                    int length = joinNames.length();  
                    System.out.println("Length: "+length);  
                    
                    // Returns StringJoiner as String type   
                    String str = joinNames.toString();  
                    System.out.println(str);  
                    
                    // Now, we can apply String methods on it  
                    char ch = str.charAt(3);  
                    System.out.println("Character at index 3: "+ch);  
                    
                    // Adding one more element   
                    joinNames.add("Sorabh");  
                    System.out.println(joinNames);  
                    
                    // Returns length  
                    int newLength = joinNames.length();  
                    System.out.println("New Length: "+newLength);  
                }  
            }