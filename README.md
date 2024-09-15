# spring_paypal
## API Payment Success
```json
{
  "id": "PAYID-MODNEDI8U3826890V695071X",
  "intent": "sale",
  "payer": {
    "payment_method": "paypal",
    "status": "VERIFIED",
    "payer_info": {
      "email": "sb-pu43hy22940511@personal.example.com",
      "first_name": "John",
      "last_name": "Doe",
      "payer_id": "FDH23LSCK9WQA",
      "country_code": "US",
      "shipping_address": {
        "recipient_name": "John Doe",
        "line1": "1 Main St",
        "city": "San Jose",
        "country_code": "US",
        "postal_code": "95131",
        "state": "CA"
      }
    }
  },
  "cart": "7YM1802406543652L",
  "transactions": [
    {
      "related_resources": [
        {
          "sale": {
            "id": "3FH72774NY953381J",
            "amount": {
              "currency": "USD",
              "total": "10.00",
              "details": {
                "subtotal": "10.00",
                "shipping": "0.00",
                "handling_fee": "0.00",
                "shipping_discount": "0.00",
                "insurance": "0.00"
              }
            },
            "payment_mode": "INSTANT_TRANSFER",
            "state": "completed",
            "protection_eligibility": "ELIGIBLE",
            "protection_eligibility_type": "ITEM_NOT_RECEIVED_ELIGIBLE,UNAUTHORIZED_PAYMENT_ELIGIBLE",
            "transaction_fee": {
              "currency": "USD",
              "value": "0.84"
            },
            "parent_payment": "PAYID-MODNEDI8U3826890V695071X",
            "create_time": "2022-11-30T03:46:35Z",
            "update_time": "2022-11-30T03:46:35Z",
            "links": [
              {
                "href": "https://api.sandbox.paypal.com/v1/payments/sale/3FH72774NY953381J",
                "rel": "self",
                "method": "GET"
              },
              {
                "href": "https://api.sandbox.paypal.com/v1/payments/sale/3FH72774NY953381J/refund",
                "rel": "refund",
                "method": "POST"
              },
              {
                "href": "https://api.sandbox.paypal.com/v1/payments/payment/PAYID-MODNEDI8U3826890V695071X",
                "rel": "parent_payment",
                "method": "GET"
              }
            ]
          }
        }
      ],
      "amount": {
        "currency": "USD",
        "total": "10.00",
        "details": {
          "subtotal": "10.00",
          "shipping": "0.00",
          "handling_fee": "0.00",
          "shipping_discount": "0.00",
          "insurance": "0.00"
        }
      },
      "payee": {
        "email": "sb-mwdmr22691351@business.example.com",
        "merchant_id": "RM9RN99HTQZ7C"
      },
      "description": "one more",
      "item_list": {
        "shipping_address": {
          "recipient_name": "John Doe",
          "line1": "1 Main St",
          "city": "San Jose",
          "country_code": "US",
          "postal_code": "95131",
          "state": "CA"
        }
      }
    }
  ],
  "failed_transactions": [],
  "state": "approved",
  "create_time": "2022-11-30T03:46:20Z",
  "update_time": "2022-11-30T03:46:35Z",
  "links": [
    {
      "href": "https://api.sandbox.paypal.com/v1/payments/payment/PAYID-MODNEDI8U3826890V695071X",
      "rel": "self",
      "method": "GET"
    }
  ]
}
```

**Note**
> khi thanh toán thì phải dùng account personal
