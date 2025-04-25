package greeting;

import io.temporal.workflow.Workflow;


public class HelloWorkflowImpl implements HelloWorkflow {
	@Override
	public String greetSomeone(String name) {
		// Simulate some workflow logic
		Workflow.sleep(1000); // Example of a non-blocking delay
		return "Hello from Temporal, I guess your name is " + name + "!" + "Also, " + name + "We need to talk about your future dreams";	
	}
}
