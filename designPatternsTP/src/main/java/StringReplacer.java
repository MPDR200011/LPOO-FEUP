public class StringReplacer implements StringTransformer {
    private StringDrink drink;
    private char pattern;
    private char replacement;

    public StringReplacer(StringDrink drink, char pattern, char replacement) {
        this.drink = drink;
        this.pattern = pattern;
        this.replacement = replacement;
    }

    @Override
    public void execute() {
        drink.setText(drink.getText().replace(pattern, replacement));
    }
}
