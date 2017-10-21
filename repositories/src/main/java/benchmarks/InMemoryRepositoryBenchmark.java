package benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import repos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Laura on 10/21/2017.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class InMemoryRepositoryBenchmark {

    public static Random random = new Random();
    /*
    Common state
     */
    @State(Scope.Benchmark)
    public static class MyState {
        public InMemoryRepository<Order> repository;
        public List<Order> orders;
        public int noOrders;

        @Setup(Level.Trial)
        public void createOrders(){
            noOrders = 100;
            orders = new ArrayList<>();
            for(int i = 0; i < noOrders; i++){
                int price = random.nextInt(50);
                int quantity = random.nextInt(10);
                Order order = new Order(i, price, quantity);
                orders.add(order);
            }
        }
    }
    /*
    States for ArrayList
     */
    /*
    State used for add.
    The repository is initially empty.
     */
    @State(Scope.Benchmark)
    public static class ArrayListAddState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ArrayListBasedRepository<>();
        }
    }
    /*
    State used for remove.
    The repository initially contains all the orders.
     */
    @State(Scope.Benchmark)
    public static class ArrayListRemoveState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ArrayListBasedRepository<>();
            for(int i = 0; i < noOrders; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
    State used for contains.
    The repository initially contains half of the orders.
     */
    @State(Scope.Benchmark)
    public static class ArrayListContainsState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ArrayListBasedRepository<>();
            for(int i = 0; i < noOrders / 2; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
    States for HashSet
     */
    /*
    State used for add.
    The repository is initially empty.
     */
    @State(Scope.Benchmark)
    public static class HashSetAddState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new HashSetBasedRepository<>();
        }
    }
    /*
    State used for remove.
    The repository initially contains all the orders.
     */
    @State(Scope.Benchmark)
    public static class HashSetRemoveState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new HashSetBasedRepository<>();
            for(int i = 0; i < noOrders; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
    State used for contains.
    The repository initially contains half of the orders.
     */
    @State(Scope.Benchmark)
    public static class HashSetContainsState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new HashSetBasedRepository<>();
            for(int i = 0; i < noOrders / 2; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
    States for TreeSet
     */
    /*
    State used for add.
    The repository is initially empty.
     */
    @State(Scope.Benchmark)
    public static class TreeSetAddState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new TreeSetBasedRepository<>();
        }
    }
    /*
    State used for remove.
    The repository initially contains all the orders.
     */
    @State(Scope.Benchmark)
    public static class TreeSetRemoveState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new TreeSetBasedRepository<>();
            for(int i = 0; i < noOrders; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
   State used for contains.
   The repository initially contains half of the orders.
    */
    @State(Scope.Benchmark)
    public static class TreeSetContainsState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new TreeSetBasedRepository<>();
            for(int i = 0; i < noOrders / 2; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
   States for ConcurrentHashMap
    */
    /*
    State used for add.
    The repository is initially empty.
     */
    @State(Scope.Benchmark)
    public static class ConcurrentHashMapAddState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ConcurrentHashMapBasedRepository<>();
        }
    }
    /*
    State used for remove.
    The repository initially contains all the orders.
     */
    @State(Scope.Benchmark)
    public static class ConcurrentHashMapRemoveState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ConcurrentHashMapBasedRepository<>();
            for(int i = 0; i < noOrders; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
   State used for contains.
   The repository initially contains half of the orders.
    */
    @State(Scope.Benchmark)
    public static class ConcurrentHashMapContainsState extends MyState {
        @Setup(Level.Iteration)
        public void createRepository(){
            repository = new ConcurrentHashMapBasedRepository<>();
            for(int i = 0; i < noOrders / 2; i++){
                repository.add(orders.get(i));
            }
        }
    }
    /*
    Helper methods for add, remove and contains benchmark tests
     */
    public Order getRandomOrder(List<Order> orders){
        int index = random.nextInt(orders.size());
        return orders.get(index);
    }

    public InMemoryRepository<Order> add(InMemoryRepository<Order> repository, List<Order> orders){
        repository.add(getRandomOrder(orders));
        return repository;
    }

    public InMemoryRepository<Order> remove(InMemoryRepository<Order> repository, List<Order> orders){
        repository.remove(getRandomOrder(orders));
        return repository;
    }

    public InMemoryRepository<Order> contains(InMemoryRepository<Order> repository, List<Order> orders){
        repository.contains(getRandomOrder(orders));
        return repository;
    }
    /*
    ArrayList benchmarks
     */
    @Benchmark
    public InMemoryRepository<Order> addArrayList(ArrayListAddState state){
        state.repository = add(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> removeArrayList(ArrayListRemoveState state){
        state.repository = remove(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> containsArrayList(ArrayListContainsState state){
        state.repository = contains(state.repository, state.orders);
        return state.repository;
    }
    /*
    HashSet benchmarks
     */
    @Benchmark
    public InMemoryRepository<Order> addHashSet(HashSetAddState state){
        state.repository = add(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> removeHashSet(HashSetRemoveState state){
        state.repository = remove(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> containsHashSet(HashSetContainsState state){
        state.repository = contains(state.repository, state.orders);
        return state.repository;
    }
    /*
    TreeSet benchmarks
     */
    @Benchmark
    public InMemoryRepository<Order> addTreeSet(TreeSetAddState state){
        state.repository = add(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> removeTreeSet(TreeSetRemoveState state){
        state.repository = remove(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> containsTreeSet(TreeSetContainsState state){
        state.repository = contains(state.repository, state.orders);
        return state.repository;
    }
    /*
   ConcurrentHashMap benchmarks
    */
    @Benchmark
    public InMemoryRepository<Order> addConcurrentHashMap(ConcurrentHashMapAddState state){
        state.repository = add(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> removeConcurrentHashMap(ConcurrentHashMapRemoveState state){
        state.repository = remove(state.repository, state.orders);
        return state.repository;
    }

    @Benchmark
    public InMemoryRepository<Order> containsConcurrentHashMap(ConcurrentHashMapContainsState state){
        state.repository = contains(state.repository, state.orders);
        return state.repository;
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InMemoryRepositoryBenchmark.class.getSimpleName())
//                .addProfiler(HotspotMemoryProfiler.class)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
