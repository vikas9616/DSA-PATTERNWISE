import java.util.*;

class Router {
    int n; // maximum number of packets router can hold
    Queue<Packet> q = new LinkedList<>(); // stores packets in arrival order
    Set<Packet> s = new HashSet<>();      // tracks unique packets to prevent duplicates
    Map<Integer, List<Integer>> m = new HashMap<>(); // destination -> list of timestamps

    public Router(int memoryLimit) {
        n = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet a = new Packet(source, destination, timestamp);

        // check if the packet already exists
        if (s.contains(a)) return false;

        // remove the oldest packet if memory limit is reached
        if (q.size() >= n) {
            Packet x = q.remove();
            m.get(x.d).remove(0); // remove timestamp from destination list
            s.remove(x);           // remove from set
        }

        m.putIfAbsent(destination, new ArrayList<>()); // initialize list if missing
        m.get(destination).add(timestamp);             // store timestamp for destination

        q.add(a); // add new packet to queue
        s.add(a); // add new packet to set
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0]; // return empty if no packets

        Packet x = q.remove();        // remove oldest packet
        m.get(x.d).remove(0);         // remove timestamp from destination list
        s.remove(x);                  // remove from set
        return new int[]{x.s, x.d, x.t}; // return packet details
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> a = m.get(destination);
        if (a == null || a.isEmpty()) return 0; // no packets for this destination

        // binary search for first timestamp >= startTime
        int l = 0, r = a.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) < startTime) l = mid + 1;
            else r = mid;
        }
        int left = l;

        // binary search for first timestamp > endTime
        l = 0; r = a.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) <= endTime) l = mid + 1;
            else r = mid;
        }
        int right = l;

        return Math.max(0, right - left); // number of packets in the time range
    }
}

class Packet {
    int s, d, t; // source, destination, timestamp

    Packet(int s, int d, int t) {
        this.s = s; this.d = d; this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        Packet x = (Packet) o;
        return this.s == x.s && this.d == x.d && this.t == x.t;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, d, t); // ensures correct behavior in HashSet
    }
}