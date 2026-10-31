package com.telefonica.telecom.common.dto;

import java.time.LocalDateTime;

public class ApiResponse<T>
{
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse()
    {
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(String message, T data)
    {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> success(String message)
    {
        return success(message, null);
    }

    // (Optional) It's highly likely you will need an error method soon, let's add it now:
    public static <T> ApiResponse<T> error(String message)
    {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    // Getters and Setters
    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getData()
    {
        return data;
    }

    // --- Static Factory Methods needed by the other services ---

    public void setData(T data)
    {
        this.data = data;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }
}