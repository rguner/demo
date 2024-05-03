package com.example.demo;

import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;


@Configuration
@ConfigurationProperties(prefix = "spring.redis.redisson")
public class RedissonNodesAutoConfig {

    private List<RedissonNodeConfig> nodesConfig;

    /**
     * Get List of Redisson Nodes Config configured
     *
     * @return list of nodes config
     */
    public List<RedissonNodeConfig> getNodesConfig() {
        return nodesConfig;
    }

    /**
     * Set list of Redisson Nodes Config configured
     * 
     * @param nodesConfig list of nodes config
     */
    public void setNodesConfig(List<RedissonNodeConfig> nodesConfig) {
        this.nodesConfig = nodesConfig;
    }

    public static class RedissonNodeConfig {
        private String edgeId;
        private Config config;
        private String configProperties;

        /**
         * Get EdgeId
         * 
         * @return edgeId configured
         */
        public String getEdgeId() {
            return edgeId;
        }

        /**
         * Set EdgeId
         * 
         * @param edgeId edgeId to set
         */
        public void setEdgeId(String edgeId) {
            this.edgeId = edgeId;
        }

        /**
         * Get Edge Redisson Config
         * 
         * @return Edge Redisson config
         */
        public Config getConfig() {
            return config;
        }

        /**
         * Set Edge Redisson Config
         * 
         * @param config redisson config to set
         */
        public void setConfig(Config config) {
            this.config = config;
        }

        public String getConfigProperties() {
            return configProperties;
        }

        public void setConfigProperties(String configProperties) throws IOException {
            this.configProperties = configProperties;
            this.config = Config.fromYAML(configProperties);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nRedisson Edge Info : ");
            sb.append("\n EdgeId : " + edgeId);
            try {
                sb.append("\n Config : " + config.toYAML());
            } catch (IOException e) {
                sb.append("\n Config : " + config);
            }
            return sb.toString();
        }
    }
}
