package ca.volatilecobra77.sable_robotics.Graph.Nodes.Data;

import ca.volatilecobra77.sable_robotics.Graph.GraphConnection;
import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;

import java.util.UUID;

public class DataPort extends NodePort {
    private BaseDataNode parent;
    public DataPort(GraphDataType type, String name, BaseDataNode parentNode, boolean input, int id, Object data) {
        super(type, name, parentNode.getId(), input, id, data);
        this.parent = parentNode;
    }

    //propogate backwards approach
    @Override
    public Object data() {
        if (input){
            // call the associated connection
            GraphConnection conn = this.parent.getConnectionForPort(this);
            NodePort nextPort = conn.sourcePort();
            return nextPort.data();
        }else{
            //its an output, call the parent nodes run function, set own data to that result and return
            this.data = parent.run();
            return this.data;
        }

    }
}
