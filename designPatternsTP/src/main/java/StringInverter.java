public class StringInverter implements StringTransformer{

    private StringDrink drink;

    public StringInverter(StringDrink drink) {
        this.drink = drink;
    }

    @Override
    public void execute() {
        drink.setText(new StringBuffer(drink.getText()).reverse().toString());
    }
}
