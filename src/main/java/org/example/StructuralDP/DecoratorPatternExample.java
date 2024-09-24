package org.example.StructuralDP;

// Component
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorator: Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 1.5; // Adding milk costs an additional 1.5
    }
}

// Concrete Decorator: Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5; // Adding sugar costs an additional 0.5
    }
}

// Concrete Decorator: Whip
class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return super.cost() + 2.0; // Adding whip costs an additional 2.0
    }
}

// Main class to demonstrate the Decorator Pattern
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.cost());

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.cost());

        Coffee milkSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(milkSugarCoffee.getDescription() + " $" + milkSugarCoffee.cost());

        Coffee fancyCoffee = new WhipDecorator(new SugarDecorator(new MilkDecorator(new SimpleCoffee())));
        System.out.println(fancyCoffee.getDescription() + " $" + fancyCoffee.cost());
    }
}
