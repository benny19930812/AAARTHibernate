package action;

import java.util.ArrayList;

import org.hibernate.property.access.spi.PropertyAccessSerializationException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.format.Parser;

import model.TruckBean;

public class DemoSpELAction1 {

	private void processAction1() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression express = parser.parseExpression("'hola,' + ' Amigo!!'");
		String result = express.getValue().toString();
		System.out.println("Result:" + result);
	}
	
	public void processAction2() {
	ExpressionParser parser = new SpelExpressionParser();
	
	EvaluationContext ectx= new StandardEvaluationContext();
	
	TruckBean truck1 = new TruckBean(2001, "Subaru");
	TruckBean truck2 = new TruckBean(2002,"Ferrari");
	
	ArrayList<TruckBean> list = new ArrayList<TruckBean>();
	list.add(truck1);
	list.add(truck2);
	
	ectx.setVariable("list", list);
	
	String brand = parser.parseExpression("#list[1].brand").getValue(ectx,String.class);
	System.out.println("brand: "+brand);
	
	}

	public static void main(String[] args) {
		DemoSpELAction1 action1 = new DemoSpELAction1();
//		action1.processAction1();
		action1.processAction2();
	}

}
