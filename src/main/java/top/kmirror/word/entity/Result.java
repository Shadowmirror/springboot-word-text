package top.kmirror.word.entity;

/**
 * @author Kmirror
 * @version 1.0
 * @className Result
 * @description //TODO
 * @date 2021/6/25 19:25
 **/

public class Result {
        private String message;
        private boolean success;
        private Object data;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Result(String message, boolean success, Object data) {
            this.message = message;
            this.success = success;
            this.data = data;
        }
}
