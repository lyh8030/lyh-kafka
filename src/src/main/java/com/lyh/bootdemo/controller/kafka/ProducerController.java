package com.lyh.bootdemo.controller.kafka;


import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @PostMapping(value = "kafka/testTransactional")
    @Transactional
    public String a(String topic, String key, String msg,int num) {
        Producer producer = kafkaTemplate.getProducerFactory().createProducer();

        for (int i = 0; i <= num; i++) {
            if (i == 7) {
                throw new RuntimeException("测试kafka事务回退");
            }
            kafkaTemplate.send(topic, key + i, msg + i);
        }
        return "发送成功";
    }
}
