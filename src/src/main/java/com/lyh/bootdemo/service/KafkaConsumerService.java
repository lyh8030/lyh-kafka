package com.lyh.bootdemo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KafkaConsumerService {


    /**
     * '@KafkaListener' 是支持配置 containerFactory 属性的，而 containerFactory 中是可以配置kafka的bootstrapServers等其他一系列参数
     * TODO 这里只配置了一个 containerFactory ，不用指定了
     * KafkaListener支持Spring EL表达式（EL不是正则哈）
     * jdk8的新特性之一，注解可以重复标注 @Repeatable(KafkaListeners.class)
     * 非手动提交的时候，不能Acknowledgment acknowledgment参数
     */

    @KafkaListeners({
            @KafkaListener(topics = {"test", "test1"}),
            @KafkaListener(topics = {"test2", "test3"}),
            @KafkaListener(topics = {"test4", "test5"}),
            @KafkaListener(topics = {"test6", "test7"})
    })
    @KafkaListener(topics = {"test8", "test9", "test10", "test11"})
    @Transactional
    public void onMessage(List<ConsumerRecord<String, Object>> list, Acknowledgment ack) {
        System.out.println("当前线程：  " + Thread.currentThread().getName());
        if (list.size() >= 5) {
            throw new RuntimeException("xxxxxxxxxxxxxxxxxxxxxx");
        }
        for (ConsumerRecord record : list) {
            System.out.printf("SpringBoot注解配置消费者测试 topic = %s, partition = %s, offset = %d, key = %s, value = %s%n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
        }
        ack.acknowledge();
    }

    public void onMessage1(List<ConsumerRecord<String, Object>> list, Acknowledgment ack) {
        System.out.println("当前线程：  " + Thread.currentThread().getName());
        for (ConsumerRecord record : list) {
            System.out.printf("SpringBoot注解配置消费者测试 topic = %s, partition = %s, offset = %d, key = %s, value = %s%n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
        }
        ack.acknowledge();
    }

    public void onMessage2(List<ConsumerRecord<String, Object>> list, Acknowledgment ack) {
        System.out.println("当前线程：  " + Thread.currentThread().getName());
        for (ConsumerRecord record : list) {
            System.out.printf("SpringBoot注解配置消费者测试 topic = %s, partition = %s, offset = %d, key = %s, value = %s%n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
        }
        ack.acknowledge();
    }


}
