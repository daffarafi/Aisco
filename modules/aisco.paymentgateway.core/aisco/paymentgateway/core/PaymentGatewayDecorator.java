package aisco.paymentgateway.core;

import aisco.paymentgateway.core.PaymentGateway;
import java.util.ArrayList;
import java.util.List;

public abstract class PaymentGatewayDecorator extends PaymentGatewayComponent {
    public PaymentGatewayComponent gateway;

    public PaymentGatewayDecorator()
    {
        
    }

    public PaymentGatewayDecorator (PaymentGatewayComponent gateway)
    {
        this.gateway = gateway;
    }
}
