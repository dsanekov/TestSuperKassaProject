package main.services;

import main.dto.Response;

public interface Service {
    Response modify(int id, int add);
}
