public class StringCaseChanger implements StringTransformer {

    private StringDrink drink;

    public StringCaseChanger(StringDrink drink) {
        this.drink = drink;
    }

    @Override
    public void execute() {
        StringBuffer buffer = new StringBuffer();
        for (char ch: drink.getText().toCharArray()) {
            if (Character.isLowerCase(ch)) {
                buffer.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                buffer.append(Character.toLowerCase(ch));
            } else {
                buffer.append(ch);
            }
        }
        drink.setText(buffer.toString());
    }
}
