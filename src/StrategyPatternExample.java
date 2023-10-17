// Interface para Payment Strategy
interface PaymentStrategy {
    void pay(int amount);
}

// Implementação concreta de Strategy para cartões
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card " + cardNumber);
    }
}

// Implementação concreta de Strategy para pagamento via Paypal
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

// Classe que utiliza a Strategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Classe principal para rodar teste
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Cria um 'shopping cart'
        ShoppingCart cart = new ShoppingCart();

        // Usa pagamento via cartão
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100);

        // Usa pagamento via Paypal
        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout(50);
    }
}