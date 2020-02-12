package hu.exth.l4tgt.model.Textures;

import java.util.List;

public interface TextureHandler {
    Texture getTextureById(int id);
    Texture getTextureByName(String name);
    List<Texture> getTexturesInGroup(String group);
    List<String> getTextureGroupNames(String group);
    int getIdByName(String name);
}
