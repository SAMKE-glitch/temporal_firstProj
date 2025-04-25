package greeting;


import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;


public class WorkerApp {
	public static void main(String[] args) {
		// Step 1: Connect to Temporal
		WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
		WorkflowClient client = WorkflowClient.newInstance(service);

		// Step 2: Register a worker factory
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker("greeting-tasks");

		// Step 3: Register the workflow implementation
		worker.registerWorkflowImplementationTypes(HelloWorkflowImpl.class);

		// Step 4: Start polling
		factory.start();
		System.out.println("Worker Started");
	}
}
