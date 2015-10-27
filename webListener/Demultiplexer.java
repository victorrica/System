package webListener;

import com.nhncorp.mods.socket.io.SocketIOServer;
import com.nhncorp.mods.socket.io.SocketIOSocket;

import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;

public class Demultiplexer implements Runnable {

    private SocketIOServer ioServer;
    private SocketIOSocket socket;
    private MysqlHandler mysqlHandler;

    public Demultiplexer(SocketIOServer ioServer, SocketIOSocket socket) {
        this.ioServer = ioServer;
        this.socket = socket;
        this.mysqlHandler = new MysqlHandler("localhost", "root",
            "klpsoma123", socket);
    }

    public void run() {

        socket.on("realtimeOn", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String emitTo = "realtimeOn res";
                mysqlHandler.realtimeOn(emitTo);
            }
        });

        socket.on("realtimeClose", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String emitTo = "realtimeClose res";
                mysqlHandler.realtimeClose(emitTo);
            }
        });

        socket.on("tcpudp hour", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String emitTo = "tcpudp hour res";
                mysqlHandler.tcpudp(emitTo, "traffic", "hour");
            }
        });

        socket.on("tcpudp min", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp min res";
              mysqlHandler.tcpudp(emitTo, "traffic", "min");
            }
        });

        socket.on("tcpudp sec", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp sec res";
              mysqlHandler.tcpudp(emitTo, "traffic", "sec");
            }
        });

        socket.on("tcpudp day", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp day res";
              mysqlHandler.tcpudp(emitTo, "traffic", "day");
            }
        });

        socket.on("tcpudp mon", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp mon res";
              mysqlHandler.tcpudp(emitTo, "traffic", "mon");
            }
        });

        socket.on("tcpudp year", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp year res";
              mysqlHandler.tcpudp(emitTo, "traffic", "year");
            }
        });

        socket.on("tcpudp user sec", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user sec res";
              mysqlHandler.tcpudp(emitTo, "user", "sec");
            }
        });

        socket.on("tcpudp user min", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user min res";
              mysqlHandler.tcpudp(emitTo, "user", "min");
            }
        });

        socket.on("tcpudp user hour", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user hour res";
              mysqlHandler.tcpudp(emitTo, "user", "hour");
            }
        });

        socket.on("tcpudp user day", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user day res";
              mysqlHandler.tcpudp(emitTo, "user", "day");
            }
        });

        socket.on("tcpudp user mon", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user mon res";
              mysqlHandler.tcpudp(emitTo, "user", "mon");
            }
        });

        socket.on("tcpudp user year", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tcpudp user year res";
              mysqlHandler.tcpudp(emitTo, "user", "year");
            }
        });

        socket.on("tomorrow security", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "tomorrow security res";
              mysqlHandler.predictSecurity(emitTo, "tomorrow");
            }
        });

        socket.on("protocol statistics", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "protocol statistics res";
              mysqlHandler.protocolStatistics(emitTo);
            }
        });

        socket.on("inoutbound traffic sec", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic sec res";
              mysqlHandler.inoutBound(emitTo, "traffic", "sec");
            }
        });

        socket.on("inoutbound traffic min", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic min res";
              mysqlHandler.inoutBound(emitTo, "traffic", "min");
            }
        });

        socket.on("inoutbound traffic hour", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic hour res";
              mysqlHandler.inoutBound(emitTo, "traffic", "hour");
            }
        });

        socket.on("inoutbound traffic day", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic day res";
              mysqlHandler.inoutBound(emitTo, "traffic", "day");
            }
        });

        socket.on("inoutbound traffic mon", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic mon res";
              mysqlHandler.inoutBound(emitTo, "traffic", "mon");
            }
        });

        socket.on("inoutbound traffic year", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound traffic year res";
              mysqlHandler.inoutBound(emitTo, "traffic", "year");
            }
        });

        socket.on("inoutbound user sec", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user sec res";
              mysqlHandler.inoutBound(emitTo, "user", "sec");
            }
        });

        socket.on("inoutbound user min", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user min res";
              mysqlHandler.inoutBound(emitTo, "user", "min");
            }
        });

        socket.on("inoutbound user hour", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user hour res";
              mysqlHandler.inoutBound(emitTo, "user", "hour");
            }
        });

        socket.on("inoutbound user day", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user day res";
              mysqlHandler.inoutBound(emitTo, "user", "day");
            }
        });

        socket.on("inoutbound user mon", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user mon res";
              mysqlHandler.inoutBound(emitTo, "user", "mon");
            }
        });

        socket.on("inoutbound user year", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String emitTo = "inoutbound user year res";
              mysqlHandler.inoutBound(emitTo, "user", "year");
            }
        });

        socket.on("insert", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String target = jsonToString(json, "data");

                // insert 성공(201)
                JsonObject reply = new JsonObject().putString("code", "201");
                reply.putString("body", "your data was this");

                // 에러날 경우
                // 400
                // JsonObject reply = new JsonObject().putString("code","400");
                // reply.putString("body", "somethings were error");

                socket.emit("insert res", reply);
            }
        });

        socket.on("read", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String target = jsonToString(json, "data");

                // read 성공
                JsonObject reply = new JsonObject().putString("code", "200");
                reply.putString("body", "somthings were generated");

                // 에러날 경우
                // 404: 리소스가 존재하지 않을 경우
                // JsonObject reply = new JsonObject().putString("code","404");
                // reply.putString("body", "your data was this");

                // 400: 그 외의 에러는 에러 이유를 "body"에 삽입
                // JsonObject reply = new JsonObject().putString("code","400");
                // reply.putString("body", "somethings were error");

                socket.emit("read res", reply);
            }
        });

        socket.on("update", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String target = jsonToString(json, "data");

                // update 성공
                JsonObject reply = new JsonObject().putString("code", "200");
                reply.putString("body", "somethings were updated");

                // 에러날 경우
                // 404: 리소스가 존재하지 않을 경우
                // JsonObject reply = new JsonObject().putString("code","404");
                // reply.putString("body", "your data was this");

                // 400: 그 외의 에러는 에러 이유를 "body"에 삽입
                // JsonObject reply = new JsonObject().putString("code","400");
                // reply.putString("body", "somethings were error");

                socket.emit("update res", reply);
            }
        });

        socket.on("delete", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String table = jsonToString(json, "table");
                String key = jsonToString(json, "key");
                String value = jsonToString(json, "value");

                String emitTo = "delete res";
                mysqlHandler.deleteHandler(emitTo, table, key, value);
            }
        });

        socket.on("insert log", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
                String admin_idx = jsonToString(json, "admin_idx");
                String action = jsonToString(json, "action");
                String date = jsonToString(json, "date");
                date.trim();

                String emitTo = "insert log res";
                mysqlHandler.insertLogHandler(emitTo, admin_idx, action, date);
            }
        });

        socket.on("info", new Handler<JsonObject>() {
            public void handle(JsonObject json) {
              String admin_idx = jsonToString(json, "admin_idx");
              String action = jsonToString(json, "action");
              String contents = jsonToString(json, "contents");
              String date = jsonToString(json, "date");

              String emitTo = "info res";
              mysqlHandler.notifyToFirewall(emitTo, admin_idx, action,
                  contents, date);
            }
        });
    }
    
    private String jsonToString (JsonObject json, String element) {
      return json.getString(element);
    }
}
