package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "iua", urlPatterns = "/iua")
public class SimpleSer extends HttpServlet {

    private final ConcurrentHashMap<String, String> ipUserAgents = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        PrintWriter writer = resp.getWriter();

        String remoteHost = req.getRemoteHost();

        ipUserAgents.put(remoteHost, req.getHeader("user-agent"));

        for (Map.Entry<String, String> ipUserAgent : ipUserAgents.entrySet()) {
            String strIPUserAgent;

            if (ipUserAgent.getKey().equals(remoteHost)) {
                strIPUserAgent = "<b>" + ipUserAgent.getKey() + " :: " + ipUserAgent.getValue() + "</b>";
            } else {
                strIPUserAgent = ipUserAgent.getKey() + " :: " + ipUserAgent.getValue();
            }

            writer.println(strIPUserAgent);
        }

    }
}
