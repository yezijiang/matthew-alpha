package com.matthew.javabase.stream;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-25 17:32
 */
public class Order {
	private Long id;
	private String orderNo;
	private Date createTime;
	private BigDecimal amout;

	Order(Long id, String orderNo, Date createTime, BigDecimal amout) {
		this.id = id;
		this.orderNo = orderNo;
		this.createTime = createTime;
		this.amout = amout;
	}

	public Long getId() {
		return id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public BigDecimal getAmout() {
		return amout;
	}

	public static Order.OrderBuilder builder() {
		return new Order.OrderBuilder();
	}

	public static class OrderBuilder {
		private Long id;
		private String orderNo;
		private Date createTime;
		private BigDecimal amout;

		OrderBuilder() {
		}

		public Order.OrderBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public Order.OrderBuilder orderNo(String orderNo) {
			this.orderNo = orderNo;
			return this;
		}

		public Order.OrderBuilder createTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		public Order.OrderBuilder amout(BigDecimal amout) {
			this.amout = amout;
			return this;
		}

		public Order build() {
			return new Order(this.id, this.orderNo, this.createTime, this.amout);
		}

		public String toString() {
			return "Order.OrderBuilder(id=" + this.id + ", orderNo=" + this.orderNo + ", createTime=" + this.createTime + ", amout=" + this.amout + ")";
		}
	}
	public static void main(String[] args) {
		User user = new User.Builder().id(1L).phone("666").nickname("mengday").age(18).build();

		Order order = Order.builder().id(1L).orderNo("1111").build();
		order = new Order.OrderBuilder().id(1L).orderNo("1111").build();
	}

}
