package br.edu.ifpb.hotel.dtos;

public record BookResponseDTO (
    String id,
    String title,
    String author,
    String genre,
    String url) 
{ }