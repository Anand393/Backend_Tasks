package ServiceTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ServiceTest {

		

		    private ServiceClass serviceClass;

		    @Before
		    public void setUp() {
		        serviceClass = new ServiceClass();
		    }

		    @Test
		    public void testProcessAsyncTask() throws InterruptedException, ExecutionException {
		        CompletableFuture<String> future = serviceClass.asyncMethod();
		        assertEquals("Task completed successfully!", future.get());
		    }

		    @Test
		    public void testProcessAsyncTaskWithMockedDependency() throws InterruptedException, ExecutionException {
		        // Create a mock dependency
		        Dependency mockDependency = mock(Dependency.class);
		        when(mockDependency.someMethod()).thenReturn("Mocked result");

		        // Inject the mock dependency into the service
		        serviceClass.setDependency(mockDependency);

		        CompletableFuture<String> future = serviceClass.processAsyncTaskWithDependency();
		        assertEquals("Mocked result", future.get());
		    }

		    // Define a mock dependency interface
		    interface Dependency {
		        String someMethod();
		    }

		    // Modify BackendService to accept the mock dependency
		    public class ServiceClass {
		        private Dependency dependency;

		        public void setDependency(Dependency dependency) {
		            this.dependency = dependency;
		        }

		        public CompletableFuture<String> processAsyncTaskWithDependency() {
		            return CompletableFuture.supplyAsync(() -> {
		                // Simulate some task using the mocked dependency
		                return dependency.someMethod();
		            });
		        }
		    }
		
		
		
		

	}

	
	
}
