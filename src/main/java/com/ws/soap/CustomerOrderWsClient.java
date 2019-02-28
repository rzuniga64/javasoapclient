package com.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {

		// Create the service stub and pass it the WSDL URL.
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		// Create a port type out of the service that wraps all the operations.
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		// in the request we need to send in the customer id. BigInteger has some fixed values like 1,2 3.
		request.setCustomerId(BigInteger.valueOf(1));
		// Get a response back by passing in the request. We are passing in the customer ID in the request.  
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		// We get the orders for the customer in the response.
		List<Order> orders = response.getOrder();
		System.out.println("Number of orders for the customer are:" + orders.size());
	}

}
