package pl.edu.pjwstk.project;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceController {
    private final ConcurrentHashMap<Character, Integer> allResources;
    private ConcurrentHashMap<Character, Integer> allocatedResources;
    private ExecutorService requestExecutor;

    /**
     * Standard constructor initializing HashMaps.
     */

    public ResourceController() {
        allResources = new ConcurrentHashMap<>();
        allocatedResources = new ConcurrentHashMap<>();
        requestExecutor = Executors.newSingleThreadExecutor();
    }

    /**
     * This constructor adds resources to allResources ConcurrentHashMap.
     *
     * @param resources - resources to be added in format: "A:5 B:3 C:2"
     */

    public ResourceController(String[] resources) {
        allResources = new ConcurrentHashMap<>();
        allocatedResources = new ConcurrentHashMap<>();
        for (String resource : resources) {
            String[] splitResource = resource.split(":");
            allResources.put(splitResource[0].charAt(0), Integer.parseInt(splitResource[1]));
        }

        requestExecutor = Executors.newSingleThreadExecutor();
    }

    /**
     * @return ConcurrentHashMap of all resources.
     */

    public ConcurrentHashMap<Character, Integer> getAllResources() {
        return allResources;
    }

}
