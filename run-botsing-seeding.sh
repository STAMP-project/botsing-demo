# The given frame
frame=$1
# Run Botsing using the learned models
java -jar botsing-reproduction-1.0.7.jar \
-project_cp applications/LANG-9b \
-crash_log crashes/LANG-9b.log \
-target_frame $frame \
-Dsearch_budget=180 \
-model models-lang/models \
-Dp_object_pool=1.0 \
-Dtest_dir=results \
-Dpopulation=50
