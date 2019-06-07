# Java Stream
- Java provides a new **additional package in Java 8 called java.util.stream**. 
- This package consists of classes, interfaces and enum to allows functional-style operations on the elements. 
- Can use stream by **importing java.util.stream** package.

## Stream provides following features:
- Stream does **not store elements**. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
- Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
- Stream is lazy and evaluates code only when required.
- The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
- can **use stream to filter, collect, print, and convert from one data structure** to other etc.


## Java Stream Interface Methods

| **Methods**	| **Description** |                                                                                 
| ------------- | --------------- |
| boolean allMatch(Predicate<? super T> predicate) |	It returns all elements of this stream which match the provided predicate. If the stream is empty then true is returned and the predicate is not evaluated.
| boolean anyMatch(Predicate<? super T> predicate) |	It returns any element of this stream that matches the provided predicate. If the stream is empty then false is returned and the predicate is not evaluated.
| static <T> Stream.Builder<T> builder() |	It returns a builder for a Stream.
| <R,A> R collect(Collector<? super T,A,R> collector) |	It performs a mutable reduction operation on the elements of this stream using a Collector. A Collector encapsulates the functions used as arguments to collect(Supplier, BiConsumer, BiConsumer), allowing for reuse of collection strategies and composition of collect operations such as multiple-level grouping or partitioning.
| <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner) |	It performs a mutable reduction operation on the elements of this stream. A mutable reduction is one in which the reduced value is a mutable result container, such as an ArrayList, and elements are incorporated by updating the state of the result rather than by replacing the result.
| static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) |	It creates a lazily concatenated stream whose elements are all the elements of the first stream followed by all the elements of the second stream. The resulting stream is ordered if both of the input streams are ordered, and parallel if either of the input streams is parallel. When the resulting stream is closed, the close handlers for both input streams are invoked.
| long count() |	It returns the count of elements in this stream. This is a special case of a reduction.
| Stream<T> distinct() |	It returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
| static <T> Stream<T> empty() |	It returns an empty sequential Stream.
| Stream<T> filter(Predicate<? super T> predicate) |	It returns a stream consisting of the elements of this stream that match the given predicate.
| Optional<T> findAny() |	It returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
| Optional<T> findFirst() |	It returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty. If the stream has no encounter order, then any element may be returned.
| <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper) |	It returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)
| DoubleStream flatMapToDouble(Function<? super T,? extends DoubleStream> mapper) |	It returns a DoubleStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have placed been into this stream. (If a mapped stream is null an empty stream is used, instead.)
| IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper) |	It returns an IntStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)
| LongStream flatMapToLong(Function<? super T,? extends LongStream> mapper) |	It returns a LongStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)
| void forEach(Consumer<? super T> action) |	It performs an action for each element of this stream.
| void forEachOrdered(Consumer<? super T> action) |	It performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.
| static <T> Stream<T> generate(Supplier<T> s) |	It returns an infinite sequential unordered stream where each element is generated by the provided Supplier. This is suitable for generating constant streams, streams of random elements, etc.
| static <T> Stream<T> iterate(T seed,UnaryOperator<T> f) |	It returns an infinite sequential ordered Stream produced by iterative application of a function f to an initial element seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
| Stream<T> limit(long maxSize) |	It returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
<R> Stream<R> map(Function<? super T,? extends R> mapper) |	It returns a stream consisting of the results of applying the given function to the elements of this stream.
| DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) |	It returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.
| IntStream mapToInt(ToIntFunction<? super T> mapper) |	It returns an IntStream consisting of the results of applying the given function to the elements of this stream.
| LongStream mapToLong(ToLongFunction<? super T> mapper) |	It returns a LongStream consisting of the results of applying the given function to the elements of this stream.
| Optional<T> max(Comparator<? super T> comparator) |	It returns the maximum element of this stream according to the provided Comparator. This is a special case of a reduction.
| Optional<T> min(Comparator<? super T> comparator) |	It returns the minimum element of this stream according to the provided Comparator. This is a special case of a reduction.
| boolean noneMatch(Predicate<? super T> predicate) |	It returns elements of this stream match the provided predicate. If the stream is empty then true is returned and the predicate is not evaluated.
| @SafeVarargs static <T> Stream<T> of(T... values) |	It returns a sequential ordered stream whose elements are the specified values.
| static <T> Stream<T> of(T t) |	It returns a sequential Stream containing a single element.
| Stream<T> peek(Consumer<? super T> action) |	It returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.
| Optional<T> reduce(BinaryOperator<T> accumulator) |	It performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.
| T reduce(T identity, BinaryOperator<T> accumulator) |	It performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.
| <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner) |	It performs a reduction on the elements of this stream, using the provided identity, accumulation and combining functions.
| Stream<T> skip(long n) |	It returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. If this stream contains fewer than n elements then an empty stream will be returned.
| Stream<T> sorted() |	It returns a stream consisting of the elements of this stream, sorted according to natural order. If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
| Stream<T> sorted(Comparator<? super T> comparator) |	It returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
| Object[] toArray() |	It returns an array containing the elements of this stream. |
| <A> A[] toArray(IntFunction<A[]> generator) |	It returns an array containing the elements of this stream, using the provided generator function to allocate the returned array, as well as any additional arrays that might be required for a partitioned execution or for resizing.