# SCT-PapiPositionTracker

This is a tracker addon for [SimpleCompass](https://www.spigotmc.org/resources/simplecompass.63140/).
It allows to track positions defined using [PlaholderAPI placeholders](https://www.spigotmc.org/wiki/placeholderapi-placeholders/).

## How to install

- Drop the [jar file](https://github.com/arboriginal/SCT-PapiPositionTracker/releases) into your `plugins/SimpleCompass/trackers` folder
- Restart your server.

**Notes:**

- If `PlaholderAPI` plugin is not installed, this tracker will not load
- Configured positions may require some PlaceholderAPI expansions. It's up to you to install expansions you need.
- If PlaceholderAPI cannot parse a configured position coords, this one will not work.

## Configuration

Edit the file `plugins/SimpleCompass/trackers/PapiPositionTracker.yml` (automatically created the first time the tracker is loaded).

Read [settings.yml](https://github.com/arboriginal/SCT-PapiPositionTracker/blob/master/src/settings.yml) to have a look on available parameters.

## Permissions

- To use this tracker, players must have:
    - **scompass.use**
    - **scompass.track**
    - **scompass.track.PAPI_POSITION** (or **scompass.track.***)
- All named positions in `PapiPositionTracker.yml` use dynamic permissions:
    - **scompass.track.PAPI_POSITION.defined.<name>**
    - **scompass.track.PAPI_POSITION.defined.arboriginal** for example to track the position "arboriginal"
- To have access to all named positions (without **scompass.track.PAPI_POSITION.defined.<name>** for each), players need:
    - **scompass.track.PAPI_POSITION.defined.***
