class Solution {
    
    boolean[] visited1;
    boolean[] visited2;
    int tot;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        tot = 0;
        
        visited1 = new boolean[edges.length];
        visited2 = new boolean[edges.length];
        
        visited1[node1] = true;
        visited2[node2] = true;
        
        return help(edges, node1, node2);
        
        
    }
    
    public int help(int[] edges, int node1, int node2) {
        tot++;
        if(tot > edges.length) return -1;
        visited1[node1] = true;
        visited2[node2] = true;
        if(visited2[node1] && visited1[node2]) return Math.min(node1, node2);
        
        if(visited2[node1]) return node1;
        if(visited1[node2]) return node2;
        
        if(edges[node1] == -1 && edges[node2] == -1) return -1;
        if(edges[node1] == -1) return help(edges, node1, edges[node2]);
        if(edges[node2] == -1) return help(edges, edges[node1], node2);
        
        return help(edges, edges[node1], edges[node2]);
    }
    
}
