import Exception_pkg.AgentNotAvailableException;
import Exception_pkg.DuplicateEntryException;
import Exception_pkg.OverloadException;
import java.util.*;

class DeliveryManagementSystem {
    private List<Agent> agents = new ArrayList<>(); 
    private Set<String> packageIds = new HashSet<>();
    private PriorityQueue<Package> packageQueue = new PriorityQueue<>(new PackagePriorityComparator());
    private int maxPackagesPerAgent;

    public DeliveryManagementSystem(int maxPackagesPerAgent) {
        this.maxPackagesPerAgent = maxPackagesPerAgent;
    }

    public void addAgent(Agent agent) throws DuplicateEntryException {
    	//new agent is agent and old is a
    	
        for (Agent a : agents) {
            if (a.getName().equals(agent.getName())) {
                throw new DuplicateEntryException("Agent already exists");
            }
        }
        agents.add(agent);
    }

    public void addPackage(Package pkg) throws DuplicateEntryException {
        if (!packageIds.add(pkg.getId())) {
            throw new DuplicateEntryException("Package already exists");
        }
        packageQueue.add(pkg);
    }

    public void assignPackages() throws AgentNotAvailableException, OverloadException {
        while (!packageQueue.isEmpty()) {
            Package pkg = packageQueue.poll(); 
            
            List<Agent> eligibleAgents = new ArrayList<>();
            for (Agent agent : agents) {
                if (agent.getCity().equals(pkg.getDestinationCity())) {
                    eligibleAgents.add(agent);
                }
            }

            if (eligibleAgents.isEmpty()) {
                throw new AgentNotAvailableException("No agent available in " + pkg.getDestinationCity());
            }

            eligibleAgents.sort(Comparator.comparingInt(a -> a.getAssignedPackages().size()));

            eligibleAgents.get(0).assignPackage(pkg);
            System.out.println("Assigned " + pkg + " to agent " + eligibleAgents.get(0).getName());
        }
    }
}
