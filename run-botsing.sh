# Get the given frame
frame=$1
# Run Botsing on the given frame
java -jar botsing-reproduction-1.0.7.jar \
-project_cp applications/LANG-9b \
-crash_log crashes/LANG-9b.log \
-target_frame $frame \
-Dsearch_budget=180 \
-Dtest_dir=results \
-Dpopulation=50
