# launchdarkly_bug
Sample repro repository for Launchdarkly bug [https://github.com/launchdarkly/android-client-sdk/issues/77](https://github.com/launchdarkly/android-client-sdk/issues/77) 


# How to test?

## Repro steps:
1. Run the app

## Expected behavior
See toolbar with hello word text

## Actual behavior
See white screen, the app hangs at [`identify().get()`](https://github.com/mateuszkwiecinski/launchdarkly_bug/blob/master/app/src/main/java/pls/help/launchdarkly/MainActivity.kt#L36)

