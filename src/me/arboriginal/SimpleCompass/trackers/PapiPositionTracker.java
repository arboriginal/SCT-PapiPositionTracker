package me.arboriginal.SimpleCompass.trackers;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;
import com.google.common.collect.ImmutableMap;
import me.arboriginal.SimpleCompass.plugin.AbstractTracker;
import me.arboriginal.SimpleCompass.plugin.SimpleCompass;
import me.clip.placeholderapi.PlaceholderAPI;

public class PapiPositionTracker extends AbstractTracker {
  // ----------------------------------------------------------------------------------------------
  // Constructor methods
  // ----------------------------------------------------------------------------------------------

  public PapiPositionTracker(SimpleCompass plugin) {
    super(plugin);
  }

  // ----------------------------------------------------------------------------------------------
  // Actions methods
  // ----------------------------------------------------------------------------------------------

  @Override
  public List<TrackingActions> getActionsAvailable(Player player, boolean keepUnavailable) {
    List<TrackingActions> list = super.getActionsAvailable(player, keepUnavailable);

    if (keepUnavailable || !availableTargets(player, "").isEmpty()) {
      list.add(TrackingActions.START);
      list.add(TrackingActions.STOP);
    }

    return list;
  }

  // ----------------------------------------------------------------------------------------------
  // Tracker methods
  // ----------------------------------------------------------------------------------------------

  @Override
  public String trackerID() {
    return "PAPI_POSITION";
  }

  // ----------------------------------------------------------------------------------------------
  // Targets methods
  // ----------------------------------------------------------------------------------------------

  public List<String> availableTargets(Player player, String startWith) {
    List<String> list = new ArrayList<String>();
    if (datas().getKeys(false).isEmpty()) return list;

    datas().getKeys(false).forEach(candidate -> {
      if (startWith.isEmpty() || candidate.toLowerCase().startsWith(startWith.toLowerCase())) list.add(candidate);
    });

    return listFiltered(player, list);
  }

  public double[] get(Player player, String name) {
    String key = key(player, name);

    if (datas().contains(key + ".x") && datas().contains(key + ".z")) {
      try {
        double[] coords = new double[] {
            Double.parseDouble(PlaceholderAPI.setPlaceholders(player, datas().getString(key + ".x"))),
            Double.parseDouble(PlaceholderAPI.setPlaceholders(player, datas().getString(key + ".z")))
        };
        
        return coords;
      }
      catch (Exception e) {
        return null;
      }
    }

    return null;
  }

  @Override
  public List<String> list(Player player, TrackingActions action, String startWith) {
    return listFiltered(player, super.list(player, action, startWith));
  }

  // ----------------------------------------------------------------------------------------------
  // Command methods
  // ----------------------------------------------------------------------------------------------

  @Override
  public boolean perform(Player player, String command, TrackingActions action, String target, String[] args) {
    if (target == null && !action.equals(TrackingActions.ADD)) return false;

    switch (action) {
      case START:
        if (!activate(player, args[2], true)) break;
        sendMessage(player, "START", ImmutableMap.of("target", args[2]));
        break;

      case STOP:
        disable(player, args[2]);
        sendMessage(player, "STOP", ImmutableMap.of("target", args[2]));
        break;

      default:
        return false;
    }

    return true;
  }

  // ----------------------------------------------------------------------------------------------
  // Targets methods
  // ----------------------------------------------------------------------------------------------

  @Override
  public boolean set(Player player, String name, double[] coords) {
    return false;
  }

  // ----------------------------------------------------------------------------------------------
  // Storage methods
  // ----------------------------------------------------------------------------------------------

  @Override
  public MemorySection datas() {
    return (MemorySection) settings.getConfigurationSection("positions");
  }

  @Override
  public String key(Player player, String name) {
    return (name == null ? "" : name.toLowerCase());
  }
}
