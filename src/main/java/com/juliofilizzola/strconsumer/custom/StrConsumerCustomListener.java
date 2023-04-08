package com.juliofilizzola.strconsumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@MessageMapping
@KafkaListener
public @interface StrConsumerCustomListener {
  @AliasFor(annotation = KafkaListener.class, attribute = "topics")
  String[] topics() default "str-topic";

  @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
  String containerFactory() default "concurrentKafkaListenerContainerFactory";

  @AliasFor(annotation = KafkaListener.class, attribute = "groupÍd")
  String groupId() default "";

  @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
  String errorHandler() default "errorCustomHandler";

}
