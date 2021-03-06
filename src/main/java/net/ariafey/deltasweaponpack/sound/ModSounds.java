package net.ariafey.deltasweaponpack.sound;

import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent JUMP = registerSoundEvent("jump");
    public static SoundEvent BOOST = registerSoundEvent("boost");
    
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(deltasweaponpack.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
