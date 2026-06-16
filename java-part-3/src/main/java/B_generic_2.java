
public class B_generic_2 <T extends Number> {

    // 덧셈
    public T add(T num1, T num2) {
        if ( num1 instanceof Integer && num2 instanceof Integer ) {
            int result = num1.intValue() + num2.intValue();
            return (T) Integer.valueOf( result );
        } else if ( num1 instanceof Double && num2 instanceof Double ) {

        }

        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }

    static void main(String[] args) {

    }
}
