package com.example

import akka.actor.ActorSystem
import kamon.Kamon

object ApplicationMain extends App {
  Kamon.start()
  val system = ActorSystem("MyActorSystem")
  for (i <- (0 to 30)) {
    val pingActor = system.actorOf(PingActor.props, s"pingActor_${i}")
    pingActor ! PingActor.Initialize
    Thread.sleep(1000)
  }
  // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
  // see counter logic in PingActor
  //system.awaitTermination()
  Thread.sleep(1500)
  Kamon.shutdown()
}