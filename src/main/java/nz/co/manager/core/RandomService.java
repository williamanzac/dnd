package nz.co.manager.core;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.inject.Singleton;

import org.jvnet.hk2.annotations.Service;

@Service
@Singleton
public class RandomService {
	private Random random = new Random();

	public int hashCode() {
		return random.hashCode();
	}

	public boolean equals(Object obj) {
		return random.equals(obj);
	}

	public void setSeed(long seed) {
		random.setSeed(seed);
	}

	public void nextBytes(byte[] bytes) {
		random.nextBytes(bytes);
	}

	public String toString() {
		return random.toString();
	}

	public int nextInt() {
		return random.nextInt();
	}

	public int nextInt(int bound) {
		return random.nextInt(bound);
	}

	public long nextLong() {
		return random.nextLong();
	}

	public boolean nextBoolean() {
		return random.nextBoolean();
	}

	public float nextFloat() {
		return random.nextFloat();
	}

	public double nextDouble() {
		return random.nextDouble();
	}

	public double nextGaussian() {
		return random.nextGaussian();
	}

	public IntStream ints(long streamSize) {
		return random.ints(streamSize);
	}

	public IntStream ints() {
		return random.ints();
	}

	public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
		return random.ints(streamSize, randomNumberOrigin, randomNumberBound);
	}

	public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
		return random.ints(randomNumberOrigin, randomNumberBound);
	}

	public LongStream longs(long streamSize) {
		return random.longs(streamSize);
	}

	public LongStream longs() {
		return random.longs();
	}

	public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
		return random.longs(streamSize, randomNumberOrigin, randomNumberBound);
	}

	public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
		return random.longs(randomNumberOrigin, randomNumberBound);
	}

	public DoubleStream doubles(long streamSize) {
		return random.doubles(streamSize);
	}

	public DoubleStream doubles() {
		return random.doubles();
	}

	public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
		return random.doubles(streamSize, randomNumberOrigin, randomNumberBound);
	}

	public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
		return random.doubles(randomNumberOrigin, randomNumberBound);
	}
}
